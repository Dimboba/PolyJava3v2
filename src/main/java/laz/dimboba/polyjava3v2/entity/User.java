package laz.dimboba.polyjava3v2.entity;


public class User {

    private Integer id;

    private String nickname;

    private String password;

    private Integer score;

    public User(int id, String nickname, String password, int score){
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.score = score;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", score=" + score +
                '}';
    }
}
