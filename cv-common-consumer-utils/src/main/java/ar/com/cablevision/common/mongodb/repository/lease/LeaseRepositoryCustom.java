package ar.com.cablevision.common.mongodb.repository.lease;

import ar.com.cablevision.common.mongodb.domain.MacAddressLease;

public interface LeaseRepositoryCustom {

    public void upsertCustom(MacAddressLease lease) throws Exception;

}
