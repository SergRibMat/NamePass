package com.example.namepass;

public class SecurityLevel {

    private String securityWord;
    private int securityColor;
    private int i;

    public SecurityLevel(int i){
        this.i = i;
        securityLevel();
    }



    public int getSecurityColor() {
        return securityColor;
    }

    public String getSecurityWord() {
        return securityWord;
    }

    private void securityLevel(){

        String word = "Too Short";
        int color = 0;

        switch(i){

            case 0:

                color = R.color.colorAccent;
                break;

            case 1:

                color = R.color.colorGrey;
                break;
            case 2:
                word = "Low";
                color = R.color.colorRed;
                break;
            case 3:
                word = "Fair";
                color = R.color.colorYellow;
                break;
            case 4:
                word = "Good";
                color = R.color.colorBlue;
                break;
            case 5:
                word = "Excelent";
                color = R.color.colorGreen;
                break;

        }

        this.securityWord = word;
        this.securityColor = color;

    }

    public int getI() {
        return i;
    }
}
