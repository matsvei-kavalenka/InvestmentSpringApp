package lt.vilniustech.mkavalenka.investment.service;

import lt.vilniustech.mkavalenka.investment.db.AssetRepository;
import lt.vilniustech.mkavalenka.investment.model.Asset;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {
    private final AssetRepository assetRepository;

    public AssetService (AssetRepository assetRepository){
        this.assetRepository = assetRepository;
    }

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }
}

