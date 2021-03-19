import React, {Component} from 'react';
import {View, Text} from 'react-native';
import {createBottomTabNavigator, createAppContainer} from 'react-navigation';
import {createMaterialBottomTabNavigator} from 'react-navigation-material-bottom-tabs';
import {Icon} from 'react-native-elements';
import Build from './Build';
import Settings from './Settings';
import { createStackNavigator } from '@react-navigation/stack';



class Home extends Component{
    render() {
        return(
            <View>
                <Text>This is our Home Screen</Text>
            </View>
        )
    }
}

const TabNavigator=createMaterialBottomTabNavigator(
    {
        Home:{screen:Home,
            navigationOptions:{
                tabBarLabel:'Home',
                activeColor:'#ff0000',
                inactiveColor:'#000000',
                barStyle:{backgroundColor:'#67baf6'},
                tabBarIcon:()=>(
                    <View>
                        <Icon name={'home'} size={25} style={{color:'#ff0000'}}/>
                    </View>
                )
            }
        },
        Build:{screen:Build,
            navigationOptions:{
                tabBarLabel:'Build',
                activeColor:'#ff0000',
                inactiveColor:'#000000',
                barStyle:{backgroundColor:'#67baf6'},
                tabBarIcon:()=>(
                    <View>
                        <Icon name={'wallet-travel'} size={25} style={{color:'#ff0000'}}/>
                    </View>
                )
            }
            },
        Settings:{screen:Settings,
            navigationOptions:{
                tabBarLabel:'Settings',
                activeColor:'#ff0000',
                inactiveColor:'#000000',
                barStyle:{backgroundColor:'#67baf6'},
                tabBarIcon:()=>(
                    <View>
                        <Icon name={'settings'} size={25} style={{color:'#ff0000'}}/>
                    </View>
                    )
                }
    }
}
);

export default createAppContainer(TabNavigator);