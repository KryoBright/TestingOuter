package com.example.test.test.repositories;

import com.example.test.test.entities.Period;
import com.example.test.test.enums.SlotType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.ZonedDateTime;

public interface PeriodPageRepository extends PagingAndSortingRepository<Period, String>, JpaSpecificationExecutor<Period>
{
    Page<Period> findAll(Specification<Period> spec, Pageable pageable);
    static Specification<Period> equalId(String id)
    {
        return (period, cq, cb) -> {
            if (id == null)
            {
                return cb.isTrue(cb.literal(true));
            }
            else
            {
                return cb.equal(period.get("id"), id);
            }
        };
    }

    static Specification<Period> equalSlotId(String slotId)
    {
        return (period, cq, cb) -> {
            if (slotId == null)
            {
                return cb.isTrue(cb.literal(true));
            }
            else
            {
                return cb.equal(period.get("slot").get("id"), slotId);
            }
        };
    }

    static Specification<Period> equalScheduleId(String scheduleId)
    {
        return (period, cq, cb) -> {
            if (scheduleId == null)
            {
                return cb.isTrue(cb.literal(true));
            }
            else
            {
                return cb.equal(period.get("schedule").get("id"), scheduleId);
            }
        };
    }

    static Specification<Period> equalSlotType(SlotType slotType)
    {
        return (period, cq, cb) -> {
            if (slotType == null)
            {
                return cb.isTrue(cb.literal(true));
            }
            else
            {
                return cb.equal(period.get("slotType"), slotType);
            }
        };
    }

    static Specification<Period> equalAdministratorId(String administratorId)
    {
        return (period, cq, cb) -> {
            if (administratorId == null)
            {
                return cb.isTrue(cb.literal(true));
            }
            else
            {
                return cb.equal(period.get("administrator").get("id"), administratorId);
            }
        };
    }

    static Specification<Period> equalExecutorId(String executorId)
    {
        return (period, cq, cb) -> {
            if (executorId == null)
            {
                return cb.isTrue(cb.literal(true));
            }
            else
            {
                return cb.equal(period.get("executor").get("id"), executorId);
            }
        };
    }

    static Specification<Period> afterBeginTime(ZonedDateTime slotBeginTime)
    {
        return (period, cq, cb) -> {
            if (slotBeginTime == null)
            {
                return cb.isTrue(cb.literal(true));
            }
            else
            {
                return cb.greaterThanOrEqualTo(period.get("slot").get("beginTime"), slotBeginTime);
            }
        };
    }

    static Specification<Period> beforeEndTime(ZonedDateTime slotEndTime)
    {
        return (period, cq, cb) -> {
            if (slotEndTime == null)
            {
                return cb.isTrue(cb.literal(true));
            }
            else
            {
                return cb.lessThanOrEqualTo(period.get("slot").get("endTime"), slotEndTime);
            }
        };
    }

}
