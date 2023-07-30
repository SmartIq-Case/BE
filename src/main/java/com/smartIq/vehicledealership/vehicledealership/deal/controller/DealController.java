package com.smartIq.vehicledealership.vehicledealership.deal.controller;

import com.smartIq.vehicledealership.vehicledealership.User.entity.Role;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.common.authorizationChecker.AuthorizationChecker;
import com.smartIq.vehicledealership.vehicledealership.deal.mapper.DealMapper;
import com.smartIq.vehicledealership.vehicledealership.deal.model.dto.DealCreateRequest;
import com.smartIq.vehicledealership.vehicledealership.deal.model.dto.response.DealGetResponse;
import com.smartIq.vehicledealership.vehicledealership.deal.model.entity.Deal;
import com.smartIq.vehicledealership.vehicledealership.deal.service.DealCreateService;
import com.smartIq.vehicledealership.vehicledealership.deal.service.DealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * İlanların yönetiminin yapıldığı Rest Controller API sınıfıdır.
 *
 */
@RestController
@RequestMapping("/api/v1/deals")
@RequiredArgsConstructor
public class DealController {
    private final AuthorizationChecker authorizationChecker;
    private final DealCreateService dealCreateService;


    /**
     * Yeni bir ilan oluşturmak için kullanılan endpointtir.
     *
     * <list>
     *     <li>
     *         USER rolüne sahip bir kullanıcının yalnızca bir tane aktif ilanı olabilir.
     *         Eğer ikinci bir aktif ilan oluşturmaya kalkarsa hata fırlatır.
     *     </li>
     *     <li>
     *         COMPANY altında bulunan COMPANY_OWNER veya COMPANY_USER rolüne sahip bir kullanıcı
     *         dilediği kadar ilan oluşturabilir.
     *     </li>
     * </list>
     * @return
     */
    @PostMapping()
    public ResponseEntity<DealGetResponse> createDeal(
            @RequestHeader("token") String tokenCode,
            @RequestBody DealCreateRequest request
    ){
        final User requestOwner = authorizationChecker.authorize(tokenCode, Role.USER,
                Role.COMPANY_OWNER,Role.COMPANY_USER);

        final Deal createdDeal = dealCreateService.createDeal(requestOwner,request);
        final DealGetResponse dealCreatedResponse = DealMapper.toGetResponse(createdDeal);

        return ResponseEntity.ok(dealCreatedResponse);
    }


    /**
     * Bir deal'a URL üzerinden belirtilen id değeri ile erişilen endpointtir.
     *
     *
     * <list>
     *      <li>
     *          Eğer erişilmek istenen deal aktif değilse, yalnızca sahibi ve admin seviyesindeki
     *          kullanıcılar bunu görebilir.
     *      </li>
     * </list>
     * @param tokenCode
     * @param dealId
     * @return
     */
    /*
    @GetMapping("/{dealId}")
    public ResponseEntity<?> getDealById(
            @RequestHeader("token") String tokenCode,
            @PathVariable("dealId") Long dealId
    ){
        final User requestOwner = authorizationChecker.authorize(tokenCode,Role.USER,
                Role.COMPANY_USER,Role.COMPANY_USER,Role.ADMIN);

        final var dealFromDb = dealService.getDealById(requestOwner,dealId);
        final var dealGetResponse = DealMapper.toGetResponse(dealFromDb);

        return ResponseEntity.ok(dealGetResponse);
    }

     */


    /**
     * Tüm Aktif Deallara erişmek için kullanılan endpoint.
     *
     * @param tokenCode
     * @return
     */
    /*
    @GetMapping
    public ResponseEntity<?> getAllDeals(
            @RequestHeader("token") String tokenCode
    ){


        final User requestOwner = authorizationChecker.authorize(tokenCode,Role.USER,
                Role.COMPANY_USER,Role.COMPANY_USER,Role.ADMIN);

        final var dealsFromDb = dealService.getAllDeals(requestOwner);
        final var dealGetResponses = DealMapper.toGetResponse(dealsFromDb);

        return ResponseEntity.ok(dealGetResponses);
    }

     */

    /**
     * Bu istekte isteği atan kişiye bağlı olan aktif, pasif veya draft konumdakiler de dahil
     * tüm deallar geriye döner.
     *
     * @param tokenCode
     * @return
     */
    /*
    @GetMapping("/myDeals")
    public ResponseEntity<?> getMyDeals(
            @RequestHeader("token") String tokenCode
    ){

        final User requestOwner = authorizationChecker.authorize(tokenCode,Role.USER,
                Role.COMPANY_USER,Role.COMPANY_USER,Role.ADMIN);

        final var myDealsFromDb = dealService.getMyDeals(requestOwner);
        final var dealGetResponses = DealMapper.toGetResponse(dealsFromDb);

        return ResponseEntity.ok(dealGetResponses);
    }

     */


    /**
     * ID Değeri URL üzerinden belirtilen Deal'ı güncellemek için kullanılan endpointtir.
     *
     * <list>
     *     <li>
     *         İsteği atan kişi yalnızca üzerinde yetkisi olduğu deal'ı güncelleyebilir.
     *     </li>
     *     <li>
     *         ADMIN seviyesindeki kişi tüm dealları güncelleyebilir.
     *     </li>
     * </list>
     * @param tokenCode
     * @param request
     * @param dealId
     * @return
     * @param <T>
     */
    /*
    @PutMapping("/{dealId}")
    public <T> ResponseEntity<?> updateDealById(
            @RequestHeader("token") String tokenCode,
            @RequestBody @Valid T request,
            @PathVariable("dealId") Long dealId
    ){
        final User requestOwner = authorizationChecker.authorize(tokenCode,Role.USER,
                Role.COMPANY_USER,Role.COMPANY_USER,Role.ADMIN);

        final var updatedDeal = dealService.getDealById(requestOwner,dealId,request);
        final var dealGetResponse = DealMapper.toGetResponse(updatedDeal);

        return ResponseEntity.ok(dealGetResponse);
    }


    @DeleteMapping("/{dealId}")
    public ResponseEntity<?> deleteDealById(
            @RequestHeader("token") String tokenCode,
            @PathVariable("dealId") Long dealId
    ){
        final User requestOwner = authorizationChecker.authorize(tokenCode,Role.USER,
                Role.COMPANY_USER,Role.COMPANY_USER,Role.ADMIN);
        dealService.deleteDealById(requestOwner,dealId);

        return ResponseEntity.ok(null);
    }

     */











}
