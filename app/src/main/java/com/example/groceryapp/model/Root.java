package com.example.groceryapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */


 class TargetBucket1{
    public String field;
    public String index;
    public String type;
}



public class Root
{
    public int created;
    public int updated;
    public Date created_date;
    public Date updated_date;
    public String active;
    public String index_name;
    public ArrayList<String> org;
    public String org_type;
    public String source;
    public String title;
    public String external_ws_url;
    public String visualizable;
    public ArrayList<Field1> field;
    public int external_ws;
    public String catalog_uuid;
    public ArrayList<String> sector;
    public TargetBucket1 target_bucket;
    public String desc;
    public String message;
    public String version;
    public String status;
    public int total;
    public int count;
    public String limit;
    public String offset;
    public ArrayList<Record1> records;

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getIndex_name() {
        return index_name;
    }

    public void setIndex_name(String index_name) {
        this.index_name = index_name;
    }

    public ArrayList<String> getOrg() {
        return org;
    }

    public void setOrg(ArrayList<String> org) {
        this.org = org;
    }

    public String getOrg_type() {
        return org_type;
    }

    public void setOrg_type(String org_type) {
        this.org_type = org_type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExternal_ws_url() {
        return external_ws_url;
    }

    public void setExternal_ws_url(String external_ws_url) {
        this.external_ws_url = external_ws_url;
    }

    public String getVisualizable() {
        return visualizable;
    }

    public void setVisualizable(String visualizable) {
        this.visualizable = visualizable;
    }

    public ArrayList<Field1> getField() {
        return field;
    }

    public void setField(ArrayList<Field1> field) {
        this.field = field;
    }

    public int getExternal_ws() {
        return external_ws;
    }

    public void setExternal_ws(int external_ws) {
        this.external_ws = external_ws;
    }

    public String getCatalog_uuid() {
        return catalog_uuid;
    }

    public void setCatalog_uuid(String catalog_uuid) {
        this.catalog_uuid = catalog_uuid;
    }

    public ArrayList<String> getSector() {
        return sector;
    }

    public void setSector(ArrayList<String> sector) {
        this.sector = sector;
    }

    public TargetBucket1 getTarget_bucket() {
        return target_bucket;
    }

    public void setTarget_bucket(TargetBucket1 target_bucket) {
        this.target_bucket = target_bucket;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public ArrayList<Record1> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Record1> records) {
        this.records = records;
    }
}






















