package com.smartIq.vehicledealership.vehicledealership.deal.repository;

import com.smartIq.vehicledealership.vehicledealership.deal.model.entity.Deal;
import com.smartIq.vehicledealership.vehicledealership.deal.model.enums.DealStatus;
import com.smartIq.vehicledealership.vehicledealership.deal.model.enums.OwnerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends JpaRepository<Deal,Long> {

    /**
     * OwnerId ve DealType değerleri parametre olarak belirtilen Deal için
     * yazılmış özel bir sorgudur.
     *
     * Sorgu bu değerlere sahip birden fazla kayıt varsa true döner,
     * bir veya hiç sayıda kayıt varsa false döner.
     *
     * @param ownerId
     * @param dealType
     * @return
     */
    /*
    @Query("select case when count(d) > 1 then true else false end" +
            " from Deal d where d.ownerId = :ownerId and d.dealType = :dealType")
    boolean isHaveMoreThanOneActiveDeal(Long ownerId, DealType dealType);
     */


    boolean existsDealByOwnerIdAndOwnerTypeAndDealStatus(Long ownerId, OwnerType dealType,
                                                        DealStatus dealStatus);

}
