package gsontest.T1567;

public class Example {
    private final String strsdata;
    private final String strdata;
    private final double intdata;
    private final String htmldata;

    public Example(String strsdata, String strdata, double intdata, String htmldata) {
        this.strsdata = strsdata;
        this.strdata = strdata;
        this.intdata = intdata;
        this.htmldata = htmldata;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("strsdata: " + this.strsdata + "\n");
        sb.append("strdata: " + this.strdata + "\n");
        sb.append("intdata: " + this.intdata + "\n");
        sb.append("htmldata: " + this.htmldata + "\n");
        return sb.toString();
    }
}
