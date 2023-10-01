package yrx;

/**
 * ClassName: Detail
 * Package: yrx
 * Description:
 *
 * @Author yrx
 * @Create 2023/10/1 12:44
 * @Version 1.0
 */
public class Detail {
    private String selection;   // in or out
    private double fee;         // 120.8
    private String illustrate;  // 吃饭

    public Detail() {
    }

    public Detail(String selection, double fee, String illustrate) {
        this.selection = selection;
        this.fee = fee;
        this.illustrate = illustrate;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getIllustrate() {
        return illustrate;
    }

    public void setIllustrate(String illustrate) {
        this.illustrate = illustrate;
    }


}
