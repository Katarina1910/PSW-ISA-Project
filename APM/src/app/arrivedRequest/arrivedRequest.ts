import { User } from '../registration/user';

export class arrivedRequest {
    constructor(
        private  userData: User,
        private  id: any,
        private  isAccepted: boolean,
        private  reasonOfRejection: string
    ){}
}