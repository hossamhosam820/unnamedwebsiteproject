package com.elhackarz.fehu2026.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elhackarz.fehu2026.models.Announcement;

public interface AnnouncementRepo extends JpaRepository<Announcement, Long> {

}
