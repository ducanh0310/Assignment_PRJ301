/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class User {

    String acc, pass, name, gender, dob, address;
    ArrayList<Integer> his = new ArrayList<>();
    ArrayList<Integer> star = new ArrayList<>();

    public User(String acc, String pass, String name, String dob, String gender, String address) {
        this.acc = acc;
        this.pass = pass;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        connect();
    }

    public User() {
        connect();
    }

    public User(String acc, String pass) {
        this.acc = acc;
        this.pass = pass;
        connect();
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Integer> getHis() {
        return his;
    }

    public void setHis(ArrayList<Integer> his) {
        this.his = his;
    }

    public ArrayList<Integer> getStar() {
        return star;
    }

    public void setStar(ArrayList<Integer> star) {
        this.star = star;
    }

    Connection cnn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("success");
            }
        } catch (Exception e) {
        }
    }

//   
    public boolean check() {
        try {
            String str = "select * from [user] where acc = ? and pass = ?";
            pstm = cnn.prepareStatement(str);
            pstm.setString(1, acc);
            pstm.setString(2, pass);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void getUser() {
        try {
            String str = "select * from [user] where acc = ?";
            pstm = cnn.prepareStatement(str);
            pstm.setString(1, acc);
            rs = pstm.executeQuery();
            while (rs.next()) {
                acc = rs.getString(1);
                pass = rs.getString(2);
                name = rs.getString(3);
                gender = "Male";
                if (rs.getBoolean(4)) {
                    gender = "Female";
                }
                dob = "";
                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                if (rs.getDate(5) != null) {
                    dob = f.format(rs.getDate(5));
                }
                address = rs.getString(6);
                String array1[] = rs.getString(7).split("\\s+");
                for (int i = 0; i < array1.length; i++) {
                    this.his.add(Integer.parseInt(array1[i]));
                }
                String array2[] = rs.getString(8).split("\\s+");
                for (int i = 0; i < array2.length; i++) {
                    this.star.add(Integer.parseInt(array2[i]));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "User{" + "acc=" + acc + ", pass=" + pass + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", address=" + address + ", his=" + his + '}';
    }

    public void addHis(Word w) {
        try {
            if (w.getId() == 0) {
                return;
            }
            String str = "update [user]\n"
                    + "set his = ? \n"
                    + "where acc = ? ";
            pstm = cnn.prepareStatement(str);
            for (int i = 0; i < his.size(); i++) {
                if (w.getId() == his.get(i)) {
                    his.remove(i);
                }
            }
            his.add(w.getId());
            if (w.getId() == 0) {
                return;
            }
            String hist = "";
            for (Integer hi : his) {
                hist = hi + " " + hist;
            }
            pstm.setString(1, hist + " ");
            pstm.setString(2, acc);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("addHis: " + e.getMessage());
        }
    }

    
    public void register() {
        try {
            String strAdd = "INSERT INTO [user](acc, pass, name, gender, address, dob )\n"
                    + "VALUES(? ,? ,? ,? ,? ,?)";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, acc);
            pstm.setString(2, pass);
            pstm.setString(3, name);
            if (gender.equals("Male")) {
                pstm.setBoolean(4, false);
            } else {
                pstm.setBoolean(4, true);
            }
            pstm.setString(5, address);
            pstm.setDate(6, Date.valueOf(dob));
            pstm.execute();
        } catch (Exception e) {
            System.out.println("regis:" + e.getMessage());
        }
    }

    public ArrayList<Word> viewHis(ArrayList<Integer> listHis) {
        ArrayList<Word> words = new ArrayList<>();
        try {
            int id = 1;
            for (int i = listHis.size() - 1; i >= 0; i--) {

                String str = "select vie, eng, loaitu, viduv, vidue from word where id = ?";
                pstm = cnn.prepareStatement(str);

                pstm.setInt(1, listHis.get(i));
                rs = pstm.executeQuery();
                while (rs.next()) {
                    String vie = rs.getString(1);
                    String eng = rs.getString(2);
                    String loaitu = rs.getString(3);
                    String viduv = rs.getString(4);
                    String vidue = rs.getString(5);
                    Word w = new Word(id, eng, vie, loaitu, viduv, vidue);
                    words.add(w);

                }
                id++;
            }
            return words;
        } catch (Exception e) {
            System.out.println("his: " + e.getMessage());
        }
        return null;
    }
    
    
    public ArrayList<Word> viewStar(ArrayList<Integer> listStar) {
        ArrayList<Word> words = new ArrayList<>();
        try {
            int id = 1;
            for (Integer hi : listStar) {

                String str = "select vie, eng, loaitu, viduv, vidue from word where id = ?";
                pstm = cnn.prepareStatement(str);

                pstm.setInt(1, hi);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    String vie = rs.getString(1);
                    String eng = rs.getString(2);
                    String loaitu = rs.getString(3);
                    String viduv = rs.getString(4);
                    String vidue = rs.getString(5);
                    Word w = new Word(id, eng, vie, loaitu, viduv, vidue);
                    words.add(w);

                }
                id++;
            }
            return words;
        } catch (Exception e) {
            System.out.println("his: " + e.getMessage());
        }
        return null;
    }

    public void addStar(Word w) {
        try {
            if (w.getId() == 0) {
                return;
            }
            String str = "update [user]\n"
                    + "set star = ? \n"
                    + "where acc = ? ";
            pstm = cnn.prepareStatement(str);
            for (int i = 0; i < star.size(); i++) {
                if (w.getId() == star.get(i)) {
                    star.remove(i);
                }
            }
            star.add(w.getId());
            if (w.getId() == 0) {
                return;
            }
            String hist = "";
            for (Integer hi : star) {
                hist = hi + " " + hist;
            }
            pstm.setString(1, hist + " ");
            pstm.setString(2, acc);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("addStar: " + e.getMessage());
        }
    }

}
