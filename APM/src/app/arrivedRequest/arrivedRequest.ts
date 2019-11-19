import { User } from '../registration/user';

export class arrivedRequest {
    constructor(
        private  userData: User,
        private  id: any, //nadji Long na netu za angular
        private  isAccepted: boolean,
        private  reasonOfRejection: string
    ){}
}