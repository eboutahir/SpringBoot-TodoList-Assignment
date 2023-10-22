import axios from "axios";

class Tasks{
    gettasks()
    {
        return axios.get("http://localhost:9090/api/getAlltasks");
    }
}
export default new Tasks();