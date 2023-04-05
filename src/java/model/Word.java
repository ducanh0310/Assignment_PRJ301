/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Word {

    @Override
    public String toString() {
        return "Word{" + "id=" + id + ", eng=" + eng + ", vie=" + vie + ", loaitu=" + loaitu + ", viduv=" + viduv + ", vidue=" + vidue + '}';
    }

    int id;
    String eng, vie;
    String loaitu, viduv, vidue;

    public String getLoaitu() {
        return loaitu;
    }

    public Word(String eng, String vie, String loaitu, String viduv, String vidue) {
        this.eng = eng;
        this.vie = vie;
        this.loaitu = loaitu;
        this.viduv = viduv;
        this.vidue = vidue;
        connect();
    }

    public void setLoaitu(String loaitu) {
        this.loaitu = loaitu;
    }

    public String getViduv() {
        return viduv;
    }

    public void setViduv(String viduv) {
        this.viduv = viduv;
    }

    public String getVidue() {
        return vidue;
    }

    public void setVidue(String vidue) {
        this.vidue = vidue;
    }

    public Word(int id, String eng, String vie, String loaitu, String viduv, String vidue) {
        this.id = id;
        this.eng = eng;
        this.vie = vie;
        this.loaitu = loaitu;
        this.viduv = viduv;
        this.vidue = vidue;
        connect();
    }

    public Word() {
        connect();
    }

    public Word(String eng, String vie) {
        this.eng = eng;
        this.vie = vie;
        connect();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEng() {

        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getVie() {

        return vie;
    }

    public void setVie(String vie) {
        this.vie = vie;
    }

    Connection cnn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
            }
        } catch (Exception e) {
        }
    }

    public void translateVieToEng(String vie1) {
        try {
            String str = "select * from word\n"
                    + "where vie = ? ";
            pstm = cnn.prepareStatement(str);
            pstm.setString(1, vie1);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
                vie = rs.getString(2);
                eng = rs.getString(3);
                loaitu = rs.getString(4);
                viduv = rs.getString(5);
                vidue = rs.getString(6);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void translateEngToVie(String eng1) {
        try {
            String str = "select * from word\n"
                    + "where eng = ?";
            pstm = cnn.prepareStatement(str);
            pstm.setString(1, eng1);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
                vie = rs.getString(2);
                eng = rs.getString(3);
                loaitu = rs.getString(4);
                viduv = rs.getString(5);
                vidue = rs.getString(6);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getIdVie(String w) {
        int i = 0;
        try {
            String str = "select id from word\n"
                    + "where vie = ?";
            pstm = cnn.prepareStatement(str);
            pstm.setString(1, w);
            rs = pstm.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return i;
    }

    public int getIdEng(String w) {
        int i = 0;
        try {
            String str = "select id from word\n"
                    + "where vie = ?";
            pstm = cnn.prepareStatement(str);
            pstm.setString(1, w);
            rs = pstm.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return i;
    }

    public ArrayList<Word> getListWord() {
        ArrayList<Word> words = new ArrayList<>();
        try {
            String str = "select id, vie, eng, loaitu, viduv, vidue\n"
                    + "from [word]";
            pstm = cnn.prepareStatement(str);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String vie = rs.getString(2);
                String eng = rs.getString(3);
                String loaitu = rs.getString(4);
                String viduv = rs.getString(5);
                String vidue = rs.getString(6);
                Word w = new Word(id, eng, vie, loaitu, viduv, vidue);
                words.add(w);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return words;
    }

    public void addWord() {
        try {
            String str = "insert into [word] (vie, eng, loaitu, viduv, vidue)\n"
                    + "values(?, ?, ?, ?, ?)";
            pstm = cnn.prepareStatement(str);
            pstm.setString(1, vie);
            pstm.setString(2, eng);
            pstm.setString(3, loaitu);
            pstm.setString(4, viduv);
            pstm.setString(5, vidue);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("addW" + e.getMessage());
        }
    }

    public int getID() {
        int id = 0;
        try {
            
            String str = "select TOP 1 id\n"
                    + "FROM word\n"
                    + "order by id DESC;";
            pstm = cnn.prepareStatement(str);
            rs = pstm.executeQuery();
            while(rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return id;
    }

    public void Update(int id) {
        try {
            String str = "update [word]\n"
                    + "set vie = ?, \n"
                    + "eng = ?,\n"
                    + "loaitu = ?,\n"
                    + "viduv = ?,\n"
                    + "vidue = ?\n"
                    + "where id = ?";

            pstm = cnn.prepareStatement(str);
            pstm.setString(1, vie);
            pstm.setString(2, eng);
            pstm.setString(3, loaitu);
            pstm.setString(4, viduv);
            pstm.setString(5, vidue);
            pstm.setInt(6, id);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }
    }

    public void Delete(int id) {
        try {
            String str = "delete from [word] where id = ?";
            pstm = cnn.prepareStatement(str);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("del: " + e.getMessage());
        }
    }

    public Word getWordById(int id) {
        Word w = new Word();
        try {
            String str = "select * from word where id = ?";
            pstm = cnn.prepareStatement(str);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                w.setId(rs.getInt(1));
                w.setVie(rs.getString(2));
                w.setEng(rs.getString(3));
                w.setLoaitu(rs.getString(4));
                w.setViduv(rs.getString(5));
                w.setVidue(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return w;
    }
    
}
