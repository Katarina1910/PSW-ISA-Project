import { Room } from './room';

export class RoomTerms {   
    constructor(
        public id: number,
        public term1:boolean,
        public term2: boolean,
        public term3:boolean,
        public term4: boolean,
        public date: string,
        public room: Room,
       
    ){}


   
}