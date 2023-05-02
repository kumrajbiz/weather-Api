import axios from "axios";

const LOCATION_BASE_URL = "http://localhost:9099/london"

class LocationService{
    sendLocation(location){
        return axios.get(LOCATION_BASE_URL + "/", location)
    }
}

export default new LocationService();