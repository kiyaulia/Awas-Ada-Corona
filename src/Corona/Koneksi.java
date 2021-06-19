/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corona;

import java.awt.HeadlessException;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Koneksi{

    private static Connection MySQLConfig;

    public static Connection configDB() throws SQLException{
        
        try{
            String url = "jdbc:mysql://localhost/corona?serverTimezone=UTC";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            MySQLConfig = DriverManager.getConnection(url, user, pass);
            
        }catch (SQLException e){
            System.out.println("Koneksi ke DATABASE Gagal " + e.getMessage());
        }
        return MySQLConfig;
    }
    
    public static void buatAkun(String nama){
        
            if(nama != "aghi"){
                try {
                String sql = "INSERT INTO pemain(nama_pemain) VALUES ('"+ nama +"')";

                java.sql.Connection conn = (Connection) Koneksi.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute(); 
                
                }catch (HeadlessException | SQLException e) {
                    System.out.println("Nama Gagal Dimasukan" + e.getMessage());
                }
            }   
        
    }
    
    public static void buatSkor(String nama, double skor){
        
        int id = ambil_id(nama);
        
        
         try {
            String sql = "INSERT INTO nilaitertinggi (id_pemain, skor) VALUES ("+ id +" , "+ skor +")";

            java.sql.Connection conn = (Connection) Koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute(); 

        }catch (HeadlessException | SQLException e) {
            System.out.println("Skor Gagal Dimasukan" + e.getMessage());
        }       
    }
    
    
    public static int ambil_id(String nama){
        int nilai = 0;
        try {
            String sql = "SELECT id_pemain FROM pemain WHERE nama_pemain = '"+ nama +"'";
            
            java.sql.Connection conn = (Connection) Koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            
//            nilai = rs.getInt("id_pemain");
            while(rs.next()){
                nilai = rs.getInt("id_pemain");    
              
            }

        }catch (HeadlessException | SQLException e) {
            System.out.println("Id Gagal diambil" + e.getMessage());
        }
        return nilai;
    } 
    
//    public static String ganti_nama (String lama, String baru){
//       
//        try {
//            String sql = "SELECT nama_pemain FROM pemain WHERE nama_pemain = '"+ baru +"'";
//            
//            java.sql.Connection conn = (Connection) Koneksi.configDB();
//            java.sql.Statement stm = conn.createStatement();
//            
//            ResultSet rs = stm.executeQuery(sql);
//            
////            nilai = rs.getInt("id_pemain");
//            while(rs.next()){
//                if (baru == rs.getString("nama_pemain")){
//                    JOptionPane.showMessageDialog(null, "Nama berhasil ditemukan");
//                    return baru;
//                }
//                  
//            }
//            System.out.println("Nama tidak ditemukan");
//
//        }catch (HeadlessException | SQLException e) {
//            System.out.println("nama Tidak" + e.getMessage());
//        }
//        return lama;
//    } 
    
    
}
