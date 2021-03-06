package com.griddynamics.jagger.engine.e1.services;

import com.griddynamics.jagger.engine.e1.aggregator.session.model.TagEntity;

import java.util.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 * User: mnovozhilov
 * Date: 1/25/14
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */

public class SessionMetaDataStorage {

    private StringBuilder sessionComment;
    private Set<String> sessionTags=new HashSet<String>();
    private List<TagEntity> tagsForSaveOrUpdate= new LinkedList<TagEntity>();

    public SessionMetaDataStorage() {
        sessionComment = new StringBuilder();
    }

    public SessionMetaDataStorage(String commentDefaultValue){
        sessionComment = new StringBuilder(commentDefaultValue);
    }

    public synchronized void setComment(String comment){
        sessionComment = new StringBuilder(comment);
    }

    public synchronized void appendToComment(String toComment){
        sessionComment.append(toComment);
    }

    public synchronized String getComment(){
        return sessionComment.toString();
    }

    public synchronized void addNewOrUpdateTag(TagEntity newTag){
        tagsForSaveOrUpdate.add(newTag);
    }

    public synchronized void addSessionTag(String sessionTagName){
        sessionTags.add(sessionTagName);
    }

    public synchronized List<TagEntity> getTagsForSaveOrUpdate() {
        return tagsForSaveOrUpdate;
    }

    public synchronized Set<String> getSessionTags() {
        return sessionTags;
    }
}
