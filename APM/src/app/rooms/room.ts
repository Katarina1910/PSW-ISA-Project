enum Type {examination, operation}
export class Room {   
    constructor(
        public id: number,
        public name: string,
        public type: Type,
        public isFree: boolean,
       // public free: string,
       
    ){}


   
}