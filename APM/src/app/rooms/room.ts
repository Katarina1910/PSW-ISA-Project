enum Type {examination, operation}
export class Room {   
    constructor(
        private  id: number,
        private  type: Type,
        private  isFree: boolean,
        private  name: string,
    ){}
}