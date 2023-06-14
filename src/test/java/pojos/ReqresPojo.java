package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqresPojo {


    private String name;

   private String Job;
    private String userId;
    private String title;
    public ReqresPojo() {
    }

    public ReqresPojo(String name, String job) {
        this.name = name;
        Job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return Job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        Job = job;
    }

    @Override
    public String toString() {
        return "pojo.ReqresPojo{" +
                "name='" + name + '\'' +
                ", Job='" + Job + '\'' +
                '}';
    }
}
