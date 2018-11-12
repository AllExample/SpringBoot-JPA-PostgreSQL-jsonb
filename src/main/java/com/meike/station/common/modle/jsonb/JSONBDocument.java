package com.meike.station.common.modle.jsonb;


import java.util.Date;

public class JSONBDocument implements JSONType{

    public JSONBDocument(Date created, String description) {
        this.created = created;
        this.description = description;
    }

    private Date created;
    private String description;

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getCreated() {
        return created;
    }

    public JSONBDocument created(final Date created) {
        this.created = created;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public JSONBDocument description(final String description) {
        this.description = description;
        return this;
    }

}
