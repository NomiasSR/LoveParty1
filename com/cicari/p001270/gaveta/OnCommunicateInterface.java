package com.cicari.p001270.gaveta;

import java.util.HashMap;

public interface OnCommunicateInterface {
    HashMap<String, String> getDadosMapa();

    void limparDadosMapa();

    void removeDadosMapa(String str);

    void setDadosMapa(String str, String str2);

    void setTotalMyTopicsOnTab();
}
