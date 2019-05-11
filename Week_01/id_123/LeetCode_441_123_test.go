package id_123

import "testing"

func Test_arrangeCoins(t *testing.T) {
	type args struct {
		n int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "test1",
			args: args{
				n: 3,
			},
			want: 2,
		},
		{
			name: "test2",
			args: args{
				n: 5,
			},
			want: 2,
		},
		{
			name: "test3",
			args: args{
				n: 5,
			},
			want: 2,
		},
		{
			name: "test4",
			args: args{
				n: 6,
			},
			want: 3,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := arrangeCoins(tt.args.n); got != tt.want {
				t.Errorf("arrangeCoins() = %v, want %v", got, tt.want)
			}
		})
	}
}
