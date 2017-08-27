package com.msir.dto;

import java.util.List;

/**
 * Created by Fantasy on 2017/8/27.
 */
public class AuthenticateDTO {
    private List<Configurations> configurations;

    public List<Configurations> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<Configurations> configurations) {
        this.configurations = configurations;
    }
}
