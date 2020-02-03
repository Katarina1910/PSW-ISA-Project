import { User } from '../registration/user';

export class RequestForAbsence {
    constructor(
        public  id: number,
        public  applicant: User,
        public  isAccepted: boolean,
        public resaonOfRejection: string,
        public from: Date,
        public to: Date,
    ){}
}