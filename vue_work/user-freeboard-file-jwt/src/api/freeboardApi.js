import axios from "axios";

const URL = 'http://localhost:8080/freeboard';

export const getFreeBoardView = async (idx) => {
    console.log(`${URL}/view/${idx}`);
    try {
        const res = await axios.get(`${URL}/view/${idx}`);
        return res;
    } catch (e) {
        console.log(e);
        return e;
    }
};

export const freeboardDelete = async (idx) => {
    try {
        const res = await axios.delete(`${URL}/delete/${idx}`)
        return res;
    } catch (e) {
        console.log(e);
        return e;
    }
}