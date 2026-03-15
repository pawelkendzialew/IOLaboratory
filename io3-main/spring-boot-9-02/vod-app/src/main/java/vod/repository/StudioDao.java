package vod.repository;

import vod.model.Studio;

import java.util.List;

public interface StudioDao {

    List<Studio> findAll();

    Studio findById(int id);

    Studio add(Studio d);


}
