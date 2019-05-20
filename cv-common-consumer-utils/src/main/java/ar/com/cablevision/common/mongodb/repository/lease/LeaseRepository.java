package ar.com.cablevision.common.mongodb.repository.lease;

import ar.com.cablevision.common.mongodb.domain.MacAddressLease;
import ar.com.cablevision.common.mongodb.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseRepository extends BaseRepository<MacAddressLease>, LeaseRepositoryCustom {


}
