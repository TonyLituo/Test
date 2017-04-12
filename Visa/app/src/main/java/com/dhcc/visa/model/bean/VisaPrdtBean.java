package com.dhcc.visa.model.bean;

import android.widget.Button;

/**
 * Created by Administrator on 2017/4/11.
 */

public class VisaPrdtBean {
//   private ImageView imageView;
//    private int imageId;
//
//    public VisaPrdtBean(int imageId) {
//        this.imageId = imageId;
//    }
//
//    public ImageView getImageView() {
//        return imageView;
//    }
//
//    public void setImageView(ImageView imageView) {
//        this.imageView = imageView;
//    }
//
//    public int getImageId() {
//        return imageId;
//    }
//
//    public void setImageId(int imageId) {
//        this.imageId = imageId;
//    }

    private String tvPrdtName;
    private String tvSignOutRate;
    private String tvSignOutRateData;
    private Button btnKeJiaJi;
    private Button btnBaoHuiYou;
    private Button btnManJianFei;
    private String tvOriginalPrice;
    private String tvNumberOfPeopleHandling;
    private String tvNumberOfPeopleComments;
    private String tvCurrentPrice;

    public VisaPrdtBean(String tvPrdtName,  String tvSignOutRateData, String tvOriginalPrice, String tvNumberOfPeopleHandling,
                        String tvNumberOfPeopleComments, String tvCurrentPrice) {
        this.tvPrdtName = tvPrdtName;
//        this.tvSignOutRate = tvSignOutRate;
        this.tvSignOutRateData = tvSignOutRateData;
//        this.btnKeJiaJi = btnKeJiaJi;
//        this.btnBaoHuiYou = btnBaoHuiYou;
//        this.btnManJianFei = btnManJianFei;
        this.tvOriginalPrice = tvOriginalPrice;
        this.tvNumberOfPeopleHandling = tvNumberOfPeopleHandling;
        this.tvNumberOfPeopleComments = tvNumberOfPeopleComments;
        this.tvCurrentPrice = tvCurrentPrice;
    }

    public String getTvPrdtName() {
        return tvPrdtName;
    }

    public void setTvPrdtName(String tvPrdtName) {
        this.tvPrdtName = tvPrdtName;
    }

    public String getTvSignOutRate() {
        return tvSignOutRate;
    }

    public void setTvSignOutRate(String tvSignOutRate) {
        this.tvSignOutRate = tvSignOutRate;
    }

    public String getTvSignOutRateData() {
        return tvSignOutRateData;
    }

    public void setTvSignOutRateData(String tvSignOutRateData) {
        this.tvSignOutRateData = tvSignOutRateData;
    }

    public Button getBtnKeJiaJi() {
        return btnKeJiaJi;
    }

    public void setBtnKeJiaJi(Button btnKeJiaJi) {
        this.btnKeJiaJi = btnKeJiaJi;
    }

    public Button getBtnBaoHuiYou() {
        return btnBaoHuiYou;
    }

    public void setBtnBaoHuiYou(Button btnBaoHuiYou) {
        this.btnBaoHuiYou = btnBaoHuiYou;
    }

    public Button getBtnManJianFei() {
        return btnManJianFei;
    }

    public void setBtnManJianFei(Button btnManJianFei) {
        this.btnManJianFei = btnManJianFei;
    }

    public String getTvOriginalPrice() {
        return tvOriginalPrice;
    }

    public void setTvOriginalPrice(String tvOriginalPrice) {
        this.tvOriginalPrice = tvOriginalPrice;
    }

    public String getTvNumberOfPeopleHandling() {
        return tvNumberOfPeopleHandling;
    }

    public void setTvNumberOfPeopleHandling(String tvNumberOfPeopleHandling) {
        this.tvNumberOfPeopleHandling = tvNumberOfPeopleHandling;
    }

    public String getTvNumberOfPeopleComments() {
        return tvNumberOfPeopleComments;
    }

    public void setTvNumberOfPeopleComments(String tvNumberOfPeopleComments) {
        this.tvNumberOfPeopleComments = tvNumberOfPeopleComments;
    }

    public String getTvCurrentPrice() {
        return tvCurrentPrice;
    }

    public void setTvCurrentPrice(String tvCurrentPrice) {
        this.tvCurrentPrice = tvCurrentPrice;
    }
}
