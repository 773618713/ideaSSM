package com.springmvc.DBTools;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * sql 执行
 */
public class ExecuteSqlDao extends DBDao{

    private Logger logger = LoggerFactory.getLogger(getClass());


    public static void main(String[] args) {
        try {
           /* String oldExamId = "de550e2ba12a4c239afac3944cc4aaa7";
            String oldCourseId = "S4";
            String courseexamid = "123456";

            String sql = "SELECT scoreid,fk_examstu,score,fk_question,createuser,to_char(createtime,'yyyy-MM-dd HH24:mm:ss') createtime,'" + courseexamid + "' fk_courseexam " +
                    "FROM sc_score " +
                    "WHERE deleteflag = 0 " +
                    "AND fk_examstu in (SELECT examstuid FROM sc_examstu WHERE deleteflag = 0 AND fk_exam = '" + oldExamId + "' AND fk_course = '" + oldCourseId + "' )";

            ExecuteSqlDao executeSqlDao = new ExecuteSqlDao("jdbc:oracle:thin:@10.1.89.71:1521:scorl", "SC_SCORE", "SC_SCORE2016");
            List list = executeSqlDao.queryBatch(sql);
            MapKeyCase.transformListMapKeyLowerCase(list);
            System.out.print(list.size());*/
            String oldExamId = "de550e2ba12a4c239afac3944cc4aaa7";
            String oldCourseId = "S4";
            String courseexamid = "123456";

            String sql = "select username from score_users";

            ExecuteSqlDao executeSqlDao = new ExecuteSqlDao("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "score_def", "score","oracle.jdbc.driver.OracleDriver");
            List list = executeSqlDao.queryBatch(sql);
            //MapKeyCase.transformListMapKeyLowerCase(list);
            System.out.print(list.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ExecuteSqlDao(String url,String userName,String password, String driverName) {
        super.url = url;
        super.userName = userName;
        super.password = password;
        super.driverName = driverName;
    }

    /**
     * 查询数据
     * @param sql 需要执行的sql
     * @return list嵌套Map
     * @throws Exception
     */
    public List<Map<String, Object>> query(String sql) throws Exception {
        List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
        Map<String, Object> dataMap = null;
        Connection con = getConnection();
        statement = con.createStatement();
        rs = statement.executeQuery(sql);
        ResultSetMetaData rsMeta = rs.getMetaData();
        int columnCount = rsMeta.getColumnCount();
        while (rs.next()) {
            dataMap = new HashMap<String, Object>();
            for (int i = 1; i <= columnCount; i++) {
                dataMap.put(rsMeta.getColumnLabel(i), rs.getObject(i));
            }
            dataList.add(dataMap);
        }

        closeAll();
        return dataList;
    }

    /**
     * 批量查询
     * @param sql
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> queryBatch(String sql) throws Exception {
        List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
        Map<String, Object> dataMap = null;
        Connection con = getConnection();
        con.setAutoCommit(false); //NOTE 为了设置fetchSize,必须设置为false
        PreparedStatement pstmt;

        pstmt = (PreparedStatement)connection.prepareStatement(sql);
        pstmt.setFetchSize(1000);
        System.out.println("ps.getQueryTimeout():" + pstmt.getQueryTimeout());
        System.out.println("ps.getFetchSize():" + pstmt.getFetchSize());
        System.out.println("ps.getFetchDirection():" + pstmt.getFetchDirection());
        System.out.println("ps.getMaxFieldSize():" + pstmt.getMaxFieldSize());

        ResultSet rs = pstmt.executeQuery();
        //NOTE 这里返回了就代表statement执行完成,默认返回fetchSize的数据
        ResultSetMetaData rsMeta = rs.getMetaData();
        int columnCount = rsMeta.getColumnCount();
        while (rs.next()) {
            dataMap = new HashMap<String, Object>();
            for (int i = 1; i <= columnCount; i++) {
                dataMap.put(rsMeta.getColumnLabel(i), rs.getObject(i));
            }
            dataList.add(dataMap);
        }
        closeAll();
        return dataList;
    }

}
