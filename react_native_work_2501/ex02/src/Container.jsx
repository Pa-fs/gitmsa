import React, { Component, useState } from 'react';
import { View, Text, StyleSheet, Image, TouchableOpacity, Alert } from 'react-native';

const imgArr = [{
    idx: 1,
    name: "모찌1",
    uri: require('../assets/images/gabriel_chanel.png'),
},
{
    idx: 2,
    name: "모찌2",
    uri: require('../assets/images/chanel_lejode.png'),
},
{
    idx: 3,
    name: "모찌3",
    uri: require('../assets/images/chanel_lejode1.png'),
},
]

// create a component
const Container = () => {
    const [num, setNum] = useState();
    const imgPress = (pressNum) => {
        setNum(pressNum)
    }

    return (
        <View style={styles.container}>
            <Text style={{color: '#fbfbfb', fontSize: 30, width:'100%', paddingHorizontal:20}}>Container</Text>

            {imgArr.map(image => {
                return (
                    <TouchableOpacity key={image.idx} style={{width: '30%', height: 150}} onPress={() => imgPress(image.idx)}>
                        <Image source={image.uri} style={{width: '100%', height:'100%', position:'relative'}}></Image>
                        {
                            num === image.idx &&
                            <View style={{position:'absolute', bottom:0, left:0, backgroundColor:'rgba(0,0,0,0.4)', width:'100%'}}>
                                <Text style={styles.textStyle}>{image.name}</Text>
                            </View>
                        }
                    </TouchableOpacity>
                )
            })}
            <Text style={styles.textStyle}>{num}</Text>
        </View>
    );
};

// define your styles
const styles = StyleSheet.create({
    container: {
        gap: 10,
        flex: 1,
        flexDirection: 'row',
        flexWrap: 'wrap',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#79e70',
    },
    textStyle : {
        color: '#000',
        fontSize: 30,
        paddingHorizontal: 20,
        width: '100%',
        textAlign: 'center',
    }
});

//make this component available to the app
export default Container;
