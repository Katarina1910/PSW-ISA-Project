import { User } from '../registration/user';

export class DoctorRequestForOperation {
    constructor(
                public id: string,
                public  dateAndTime: string,
                public  applicant: string,
                public patient:User,
            ){}
        }