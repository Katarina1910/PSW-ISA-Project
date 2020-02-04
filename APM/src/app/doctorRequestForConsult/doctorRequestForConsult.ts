import { User } from '../registration/user';
import { ConsultType } from 'src/consultType/consultType';

export class DoctorRequestForConsult {
    constructor(
                public id: string,
                public  type: ConsultType,
                public  dateAndTime: string,
                public  applicant: string,
                public patient:User,
            ){}
        }