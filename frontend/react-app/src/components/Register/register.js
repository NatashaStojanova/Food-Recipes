import React, {Component} from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import {withRouter} from "react-router-dom";
import AuthenticationService from "../../service/AuthenticationService/authenticationService"
import {AUTH_TOKEN} from "../../shared/utility";

/**
 * @author Natasha Stojanova (natashastojanova6@gmail.com)
 */
class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: '',
            email: '',
            username: '',
            password: '',
            waitResponse: false,
            errMessage: null,
        }
    }

    setErrorMessage(error) {
        this.setState({
            errMessage: 'Please choose another username',
        })
    }

    clearErrorMessage() {
        this.setState({
            errMessage: null
        })
    }

    handleClick(event) {
        this.clearErrorMessage();
        this.setState({
            waitResponse: true,
        });
        const payload = {
            "name" : this.state.name,
            "email" : this.state.email,
            "username": this.state.username,
            "password": this.state.password
        };
        debugger;
        AuthenticationService.registerUser(payload).then(resp => {
            this.setState({
                waitResponse: false,
            });
            this.props.history.push('/login');
        }).catch(error => {
            this.setErrorMessage(error);
            this.setState({
                waitResponse: false,
            });
        })
    }
    render() {
        return (
            <div class="container">
                {(!this.state.waitResponse ?
                    <MuiThemeProvider>
                        <div>
                            <br/>
                            <h1 className="text-dark">Register</h1>
                            {this.state.errMessage !== null ? <div className="text-center text-danger">
                                <span>{this.state.errMessage}</span>
                            </div> : <div/>}
                            <TextField
                                hintText="Enter your Name"
                                floatingLabelText="Name"
                                onChange={(event, newValue) => this.setState({name: newValue})}
                            />
                            <br/>
                            <TextField
                                hintText="Enter your E-mail"
                                floatingLabelText="E-mail"
                                onChange={(event, newValue) => this.setState({email: newValue})}
                            />
                            <br/>
                            <TextField
                                hintText="Enter your Username"
                                floatingLabelText="Username"
                                onChange={(event, newValue) => this.setState({username: newValue})}
                            />
                            <br/>
                            <TextField
                                type="password"
                                hintText="Enter your Password"
                                floatingLabelText="Password"
                                onChange={(event, newValue) => this.setState({password: newValue})}
                            />
                            <br/>
                            <RaisedButton label="Submit" primary={true} style={style}
                                          onClick={(event) => this.handleClick(event)}/> <br/>
                            <a href="/login">Already have an account?
                               Go to Login!</a>
                        </div>
                    </MuiThemeProvider> :
                    <div style={{display: 'flex', justifyContent: 'center', alignItems: 'center', height: '50vh'}}
                         className="container text-black-50 text-lg-center">
                        <img alt="" style={{width: "10%"}}
                             src={require('../../assets/loading.gif')}/>
                        Please wait while we process your request
                    </div>)}
            </div>
        );
    }
}

const style = {
    margin: 15,
};
export default withRouter(Register);