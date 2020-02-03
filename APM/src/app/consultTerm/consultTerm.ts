import { ConsultType } from 'src/consultType/consultType';
import { User } from '../registration/user';

export class ConsultTerm{
    constructor(
        private id:number,
        public date: Date,
        public  type: ConsultType,
        private  duration: number,
        private  price: number,
        private  discount: number,
        private room: string,
        private doctor: string,
        private patient: User
    ){}
}