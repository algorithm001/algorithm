package id_123

import "testing"

func Test_isValid(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "test1",
			args: args{
				s: "[[[]]]",
			},
			want: true,
		},
		{
			name: "test2",
			args: args{
				s: "[[()]]",
			},
			want: true,
		},
		{
			name: "test3",
			args: args{
				s: "[[(]]",
			},
			want: false,
		},
		{
			name: "test4",
			args: args{
				s: "[[{}]]",
			},
			want: true,
		},
		{
			name: "test5",
			args: args{
				s: "(]",
			},
			want: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isValid(tt.args.s); got != tt.want {
				t.Errorf("isValid() = %v, want %v", got, tt.want)
			}
		})
	}
}
