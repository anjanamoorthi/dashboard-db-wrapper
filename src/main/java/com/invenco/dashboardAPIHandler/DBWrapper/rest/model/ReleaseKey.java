package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ReleaseKey implements Serializable {

    @NotNull
    @Column(name = "releasename")
    public String releasename;

    @Column(name = "iteration")
    @ColumnDefault("1")
    public Integer iteration;

    @Column(name = "product_id")
    public Long productId;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((releasename == null) ? 0 : releasename.hashCode());
        result = prime * result + ((iteration == null) ? 0 : iteration.hashCode());
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReleaseKey other = (ReleaseKey) obj;
        if (releasename == null || !releasename.equals(other.releasename)) {
            return false;
        } else if (iteration == null || !iteration.equals(other.iteration)) {
            return false;
        } else if (productId == null || !productId.equals(other.iteration))
            return false;
        return true;
    }
}
