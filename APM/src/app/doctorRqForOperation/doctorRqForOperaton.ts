import { User } from '../registration/user';

export class DoctorRequestForOperation {
    constructor(
                public id: string,
                public  date: Date,
                public  applicant: string,
                public patient:User,
            ){}
        }