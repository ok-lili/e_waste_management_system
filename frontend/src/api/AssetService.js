import axios from 'axios';

const API_URL = 'http://localhost:8080/api/assets';

class AssetService {
    getAllAssets() {
        return axios.get(API_URL);
    }
    getAssetById(assetId) {
        return axios.get(`${API_URL}/${assetId}`);
    }
    createAsset(asset){
        return axios.post(API_URL, asset);
    }
    updateAsset(assetId,asset){
        return axios.put(`${API_URL}/${assetId}`,asset);
    }
    deleteAsset(assetId){
        return axios.delete(`${API_URL}/${assetId}`);
    }
}
export default new AssetService();