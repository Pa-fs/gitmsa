import axios from "axios";
import { useState } from "react";
import { StyleSheet, Text, TouchableOpacity, View } from "react-native";

const AA = () => {
    const [data, setData] = useState('data')
    const changeData = async () => {
        const res = await axios.get('http://localhost:20000/test/aa')
        setData('변경된 값 ' + res.data);
    }
     return (
        <View style={styles.container}>
            <Text>AA</Text>
            <Text>{data}</Text>
            <TouchableOpacity onPress={changeData}>
                <Text>Press me</Text>
            </TouchableOpacity>
        </View>
    );
}

export default AA;

const styles = StyleSheet.create({
    container: {
        backgroundColor: '#fff',
        padding: 20,
        margin: 40,
    },
})