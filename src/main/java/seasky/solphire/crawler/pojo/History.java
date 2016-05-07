package seasky.solphire.crawler.pojo;

/**
 * Created by Administrator on 2016/4/23.
 */
public class History {
    private int id;
    private int uid;
    private int gid;
    private float score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", uid=" + uid +
                ", gid=" + gid +
                ", score=" + score +
                '}';
    }
}
