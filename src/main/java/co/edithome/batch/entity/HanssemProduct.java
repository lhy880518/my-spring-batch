package co.edithome.batch.entity;/*
 * Created by hylee@insterior.co.kr
 * Since 2020/12/21
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "hanssem_product")
public class HanssemProduct extends BaseEntity implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "link")
    private String link;

    @Column(name = "link_mo")
    private String linkMo;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "price_mo")
    private BigDecimal priceMo;

    @Column(name = "price_app")
    private BigDecimal priceApp;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "scrapped_at")
    private LocalDateTime scrappedAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Column(name = "is_expired")
    private boolean expired;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    /**
     * 상품 삭제 (EP 수집 안 되었을 경우)
     */
    public void deleteProduct() {
        this.expired = true;
        this.expiredAt = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    }

    public void modify(final String link, final String linkMo, final String name, final String brand, final BigDecimal price, final BigDecimal priceMo, final BigDecimal priceApp, final String thumbnail, final LocalDateTime scrappedAt, final LocalDateTime modifiedAt) {
        this.link = link;
        this.linkMo = linkMo;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.priceMo = priceMo;
        this.priceApp = priceApp;
        this.thumbnail = thumbnail;
        this.scrappedAt = scrappedAt;
        this.modifiedAt = modifiedAt;
    }
}
