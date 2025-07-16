package com.ll.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBConnection {
    private Connection connection;
    public static String DB_NAME;
    public static String DB_USER;
    public static String DB_PASSWORD;
    public static int DB_PORT;

    public void connect() {
        String url = "jdbc:mysql://localhost:" + DB_PORT + "/" + DB_NAME
                + "?serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true";
        String user = DB_USER;
        String password = DB_PASSWORD;
        String driverName = "com.mysql.cj.jdbc.Driver";

        try {
            connection = DriverManager.getConnection(url, user, password);
            Class.forName(driverName);
            // System.out.println(Class.forName(driverName));  //class com.mysql.cj.jdbc.Driver
            System.out.println("연결성공");
        } catch (SQLException e) {
            System.err.printf("[SQL 예외] : %s\n", e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.printf("[드라이버 클래스 로딩 예외] : %s\n", e.getMessage());
        }
    }

    public int selectRowIntValue(String sql) {
        Map<String, Object> row = selectRow(sql);

        for (String key : row.keySet()) {
            return (int) row.get(key);
        }

        return -1;
    }

    public String selectRowStringValue(String sql) {
        Map<String, Object> row = selectRow(sql);

        for (String key : row.keySet()) {
            return (String) row.get(key);
        }

        return "";
    }

    public Boolean selectRowBooleanValue(String sql) {
        Map<String, Object> row = selectRow(sql);

        for (String key : row.keySet()) {
            if (row.get(key) instanceof String) {
                return ((String) row.get(key)).equals("1");
            } else if (row.get(key) instanceof Integer) {
                return ((int) row.get(key)) == 1;
            } else if (row.get(key) instanceof Boolean) {
                return ((boolean) row.get(key));
            }
        }

        return false;
    }

    public Map<String, Object> selectRow(String sql) {
        List<Map<String, Object>> rows = selectRows(sql);

        if (rows.size() == 0) {
            return new HashMap<String, Object>();
        }

        return rows.get(0);
    }

    public List<Map<String, Object>> selectRows(String sql) {
        List<Map<String, Object>> rows = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnSize = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();

                for (int columnIndex = 0; columnIndex < columnSize; columnIndex++) {
                    String columnName = metaData.getColumnName(columnIndex + 1);
                    Object value = rs.getObject(columnName);

                    if (value instanceof Long) {
                        int numValue = (int) (long) value;
                        row.put(columnName, numValue);
                    } else if (value instanceof Timestamp) {
                        String dateValue = value.toString();
                        dateValue = dateValue.substring(0, dateValue.length() - 2);
                        row.put(columnName, dateValue);
                    } else {
                        row.put(columnName, value);
                    }
                }

                rows.add(row);
            }
        } catch (SQLException e) {
            System.err.printf("[SQL 예외, SQL : %s] : %s\n", sql, e.getMessage());
            e.printStackTrace();
        }

        return rows;
    }

    public int delete(String sql) {
        int affectedRows = 0;

        Statement stmt;
        try {
            stmt = connection.createStatement();
            affectedRows = stmt.executeUpdate(sql);
            /*
            executeUpdate() 메서드는 SQL INSERT, UPDATE, DELETE 문과 같이
            데이터베이스 테이블의 내용을 변경하는 SQL 쿼리를 실행할 때 사용됩니다.
            이 메서드는 영향을 받은 행의 수를 정수로 반환합니다.
            */
        } catch (SQLException e) {
            System.err.printf("[SQL 예외, SQL : %s] : %s\n", sql, e.getMessage());
        }

        return affectedRows;
    }

    public int update(String sql) {
        int affectedRows = 0;

        Statement stmt;
        try {
            stmt = connection.createStatement();
            affectedRows = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.printf("[SQL 예외, SQL : %s] : %s\n", sql, e.getMessage());
        }

        return affectedRows;
    }

    public int insert(String sql) {
        int id = -1;

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();     // autoincrement 값을 호출하는

            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException e) {
            System.err.printf("[SQL 예외, SQL : %s] : %s\n", sql, e.getMessage());
        }

        return id;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.printf("[SQL 예외] : %s\n", e.getMessage());
            }
        }
    }
}