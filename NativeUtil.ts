import { NativeModules } from 'react-native';

const { CustomModule } = NativeModules;

const sendRequest = (msg) => {
    const {sendRequest: sendRequest} = CustomModule ?? {};
    return sendRequest && sendRequest(msg);
};

export default {
    sendRequest,
};
