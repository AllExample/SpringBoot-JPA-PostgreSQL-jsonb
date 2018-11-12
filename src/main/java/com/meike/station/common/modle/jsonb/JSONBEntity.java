package com.meike.station.common.modle.jsonb;

import com.google.common.collect.Lists;
import com.meike.station.jsonb.types.JSONBUserType;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@TypeDef(name = "jsonb", typeClass = JSONBUserType.class, parameters = {
        @Parameter(name = JSONBUserType.CLASS,
                value = "java.util.List")})
@Entity
@Table(name = "jsonb_test_entity")
public class JSONBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Type(type = "jsonb")
    private List<JSONType> documents;

    public JSONBEntity() {
        documents = Lists.newArrayList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<JSONType> getDocuments() {
        return documents;
    }

    public void setDocuments(List<JSONType> documents) {
        this.documents = documents;
    }

    public JSONBEntity documents(final JSONBDocument... documents) {
        for (JSONBDocument document : documents) {
            this.documents.add(document);
        }
        return this;
    }

    public JSONBEntity document(final JSONBDocument document) {
        this.documents.add(document);
        return this;
    }


}
