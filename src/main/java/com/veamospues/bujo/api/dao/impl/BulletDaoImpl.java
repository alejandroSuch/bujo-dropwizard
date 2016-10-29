package com.veamospues.bujo.api.dao.impl;

import com.google.inject.persist.Transactional;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.veamospues.bujo.api.dao.BulletDao;
import com.veamospues.bujo.api.dao.base.GenericAbstractDao;
import com.veamospues.bujo.api.domain.Bullet;
import com.veamospues.bujo.api.domain.QBullet;
import com.veamospues.bujo.api.domain.QTask;
import com.veamospues.bujo.api.domain.Task;

import javax.inject.Singleton;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by alejandro on 11/10/16.
 */
@Transactional
@Singleton
public class BulletDaoImpl extends GenericAbstractDao<Bullet, UUID> implements BulletDao {
  public BulletDaoImpl() {
    super(Bullet.class);
  }

  public List<Bullet> findByDateGreaterThan(Optional<Date> date) {
    final Date theDate = date.orElse(new Date());
    final Date startDate = toStartDate(theDate);

    final QBullet bullet = QBullet.bullet;

    return (List<Bullet>) queryFactory
            .from(bullet)
            .where(bullet.dateCreated.goe(startDate))
            .orderBy(bullet.dateCreated.asc())
            .fetch();
  }

  public List<Bullet> findByMonth(Optional<Date> date) {
    return null;
  }

  public List<Bullet> findByDate(Optional<Date> date) {
    final Date theDate = date.orElse(new Date());

    final Date startDate = toStartDate(theDate);
    final Date endDate = toEndDate(theDate);

    final QBullet bullet = QBullet.bullet;
    final QTask task = bullet.as(QTask.class);

    final BooleanExpression bulletIsOnDate = bullet.dateCreated.between(startDate, endDate);

    final BooleanExpression isATask = bullet.instanceOf(Task.class);

    final BooleanExpression isUnfinished = task.doneDate.isNull();
    final BooleanExpression isFinishedOnDate = task.doneDate.before(endDate);
    final BooleanExpression isCreatedBeforeStartDate = task.dateCreated.before(startDate);

    final BooleanExpression isAnUnfinishedTask = isATask.and(isCreatedBeforeStartDate).and(isUnfinished);
    final BooleanExpression isAFinishedTask = isATask.and(isCreatedBeforeStartDate).and(isFinishedOnDate);

    final BooleanExpression isCancelledBeforeStartDate = task.cancelledDate.before(startDate);
    final BooleanExpression isACancelledTask = isATask.and(isCancelledBeforeStartDate).and(isFinishedOnDate);

    return (List<Bullet>) queryFactory
            .from(bullet)
            .where(bulletIsOnDate.or(isAnUnfinishedTask).or(isAFinishedTask).or(isACancelledTask))
            .orderBy(bullet.dateCreated.asc())
            .fetch();
  }

  private Date toStartDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.MILLISECOND, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.HOUR, 0);
    return date;
  }

  private Date toEndDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.MILLISECOND, Integer.MAX_VALUE);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.HOUR, 23);
    return date;
  }
}
