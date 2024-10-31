import { useRouter } from "expo-router";
import { useEffect } from "react";
import { StyleSheet, Text, View, TouchableOpacity } from "react-native";

const index = () => {
    const router = useRouter()
    const onPress = () => {
        router.push('/(tabs)')
    }
    const onConsole = () => {
        console.log("This is console log")
    }
    const onMyMain = () => {
        router.push("/mymain")
    }

    const onAA = () => {
        router.push("/aa")
    }

    // 최초에 한 번만 실행
    // watch([], () => {}); //vue.js
    useEffect(() => {
        console.log("index component useEffect")
    }, []);

    return ( <View style={ styles.container }>
        <Text style={styles.text}>
            Index
            RouterLink - router.push
            Link - router.push
            폰트 변경
        </Text>
        <TouchableOpacity onPress={onPress}>
            <Text>Click me</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={onConsole}>
            <Text style={styles.text}>이거 누르면 출력된다</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={onMyMain}>
            <Text style={styles.text}>이거 누르면 MyMain으로 간다</Text>
        </TouchableOpacity>

        <TouchableOpacity onPress={onAA}>
            <Text style={styles.text}>이거 누르면 AA로 간다</Text>
        </TouchableOpacity>
    </View>  );
}
 
export default index;

const styles = StyleSheet.create({
    container: {
        marginTop: 50,
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center'
    },
    text: {
        fontSize: 30,
        // fontWeight: 'bold',
        fontFamily: 'JUA'
    }
});