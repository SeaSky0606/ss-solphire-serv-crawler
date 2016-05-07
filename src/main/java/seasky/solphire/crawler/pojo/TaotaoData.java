package seasky.solphire.crawler.pojo;

/**
 * Created by junhong on 2016/3/13.
 */
public class TaotaoData {

    private String id;
    private String name;
    private String director;
    private String actors;
    private String tag;
    private String area;
    private String onshow;
    private String detail;
    private float score;
    private String picUrl;

    public TaotaoData() {

    }

    public TaotaoData(String id, String name, String director, String actors, String tag, String area, String picUrl, String onshow, String detail, float score) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.tag = tag;
        this.area = area;
        this.picUrl = picUrl;
        this.onshow = onshow;
        this.detail = detail;
        this.score = score;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getOnshow() {
        return onshow;
    }

    public void setOnshow(String onshow) {
        this.onshow = onshow;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "TaotaoData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                ", tag='" + tag + '\'' +
                ", area='" + area + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", onshow='" + onshow + '\'' +
                ", detail='" + detail + '\'' +
                ", score=" + score +
                '}';
    }
}


