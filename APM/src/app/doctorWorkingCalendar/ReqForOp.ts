import { User } from '../registration/user';

export class ReqForOp {
    constructor(
        public id:number,
        public dateAndTime:string,
        public isAccepted: boolean,
        public patient: User,
        public applicant: User
     
    ) {}
}